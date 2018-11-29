package control;

import sastre.Utils;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import modelo.Paquete;
import modelo.Router;

public class BehaviourRecibir extends Behaviour {

	private static final long serialVersionUID = 1L;
	@Override
	public void action() {
		Paquete pack=new Paquete();

			//FUNCION RECIBIR MENSAJE	
		ACLMessage msg=myAgent.blockingReceive(MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("ontologia")));
			/*OBTENER EL MENSAJE Y SU REMITENTE*/
		try{	
			String id = (String) msg.getContentObject();//Transformar msg a object
			pack=Utils.recogerPack(id);
			
		}catch (UnreadableException e){
			e.printStackTrace();
		}
		if(pack!=null){
			  //COMPROBAR SI ES EL DESTINATARIO FINAL
				System.out.println("Comprobando mensaje, soy el "+myAgent.getLocalName()+"...");
				if (myAgent.getLocalName().equals(pack.getReceptor().getName().getLocalName())){
					//System.out.printf("%s %s\n", myAgent.getLocalName(),pack.getReceptor().getName().getLocalName());
					//System.out.printf("%s \n", myAgent.getLocalName());
					// Si se es el agente final muestro el ultimo mensaje
					
					Router rut = Utils.getRouter(pack.getRute().getIdSala());
					System.out.printf("Subiendo al router %s capacidad:%d\n" ,Utils.getRouter(rut.getIdSala()).getIdSala() , Utils.getRouter(rut.getIdSala()).getCapacidad());
					if(rut.getCapacidad()>=pack.getTamanio()){
						rut.setCapacidad(rut.getCapacidad()-pack.getTamanio());
						rut.getColeccionPaquetes().add(pack);
						Utils.setRouter(rut);
						Utils.resetearTurno();
					}else{
						System.out.println("No hay suficiente capacidad, lo sentimos.");
						System.exit(0);//SALIDA
					}
				}/*else{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}*/
		}else{
			System.err.println("paquete es null o el id no coincide");
		}

	
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}


}