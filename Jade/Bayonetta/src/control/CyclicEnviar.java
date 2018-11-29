package control;

import java.util.ArrayList;

import modelo.Paquete;
import modelo.Router;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import sastre.Utils;


public class CyclicEnviar extends CyclicBehaviour {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		//System.out.println("he llegado,soy el puto amo");
		DFAgentDescription [] conexiones;
		
		//System.out.printf("%d",Utils.comprobarTurno());
		String nombre=myAgent.getLocalName();
		if(Utils.comprobarTurno()<0 && myAgent.getLocalName().equals("Agente1")){
			Utils.packAleatorio();
		}
		
		if(nombre.equals("Agente"+Utils.comprobarTurno())){
			Utils.recogerTurno();
			System.out.println("generando pack...");
			Paquete pack = Utils.generarPaquete();
			System.out.println("paquete generado");
			/*try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			pack.setEmisor(myAgent.getLocalName());	
			Router route=Utils.mayorCapacidad();
			if(route.getCapacidad()>=pack.getTamanio()){
				pack.setRute(route);
				System.out.printf("Mayor capacidad"+pack.getRute().getIdSala()+"\n");
				/*try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				ArrayList <Paquete> ccp = route.getColeccionPaquetes();
				boolean flag=false;
				
				for(int i=0; i<route.getConexiones().length;i++){
					if(route.getConexiones()[i]!=null){
						if(route.getConexiones()[i].equals(myAgent.getLocalName())){
							System.out.println("Tengo conexion directa con el "+ route.getIdSala());
							route.setCapacidad(route.getCapacidad()-pack.getTamanio());
							ccp.add(pack);
							route.setColeccionPaquetes(ccp);
							Utils.setRouter(route);
							System.out.printf("Subiendo al router %s capacidad:%d\n" ,Utils.getRouter(route.getIdSala()).getIdSala() , Utils.getRouter(route.getIdSala()).getCapacidad());
							/*try {
								Thread.sleep(2000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}*/
							Utils.resetearTurno();
							flag=true;
							break;
						}
					}
				}
				if(flag==false){
					System.out.println("No tengo conexion directa con el router, procediendo a enviar mensaje");
					for(int i=0; i<route.getConexiones().length;i++){
						
						conexiones = Utils.buscarAgentes(myAgent,route.getConexiones()[i]);
						//System.out.println("AGENTE"+myAgent.getLocalName()+"conexiones"+conexiones[0].getName().getLocalName()+conexiones[1].getName().getLocalName()+conexiones[2].getName().getLocalName());
						if(conexiones!=null){
							if(conexiones[i]!=null) {
								for(int j=0;j<conexiones.length;j++) {
									if(conexiones[j]!=null){
										if(conexiones[j].getName().getLocalName().equals(myAgent.getLocalName())){
											
											
											//String dest;
											//dest= conexiones[i].getName().getLocalName();
											//AID siguiente_Agente=new AID(dest, AID.ISLOCALNAME);
											pack.setReceptor(conexiones[i]);
											System.out.println("soy el agente "+myAgent.getLocalName()+"enviando mensaje a "+pack.getReceptor().getName().getLocalName());
											String id = Utils.enviarPack(pack);
											prueba.enviarMensaje(myAgent, id);
											System.out.println("mensaje enviado"/*+myAgent.getLocalName()+conexiones[j].getName().getLocalName()+id*/);
											flag=true;
											/*
											ACLMessage msg =new ACLMessage(ACLMessage.INFORM);
											try {
												msg.setContentObject(pack);
												
												msg.addReceiver(siguiente_Agente);
												
												flag=true;
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}*/
											break;
										}
									}
								}
								
							}
						}
						if(flag){
							break;
						}
					}
					
				}
			}else{
				System.out.println("No hay suficiente capacidad, lo sentimos...");
				System.exit(0);
			}
			
		}/*else{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}*/
		
	}

}
