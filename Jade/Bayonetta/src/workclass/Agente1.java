package workclass;



import jade.content.lang.sl.SLCodec;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class Agente1 extends Agent {

	private static final long serialVersionUID = 1L;
	protected Parallel parallel;
	
	
	// conexiones del agente1
	
	private String [] conexionagente1	=	{"Agente2","Agente3","Agente5"};
	
	
	//Comportamientos
	public void setup(){
		
		int i;
		String [] conexiones=null;
		
		//
		//Registrar servicios
		//
		String nombre=getLocalName();
		
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());
		ServiceDescription sd;
		
		
		conexiones= new String [conexionagente1.length];
		for(i=0;i<conexionagente1.length;i++)
			conexiones[i]=conexionagente1[i];
		
		
		for(i=0;i<conexiones.length;i++) {
			
			sd= new ServiceDescription();
			//El nombre sera el de cada agente
			sd.setName(nombre);
			//El tipo sean los servicios que tiene cada agente
			sd.setType(conexiones[i]);
			//La ontologia no se va a usar en este caso
			sd.addOntologies("Ontologia");
	
			sd.addLanguages(new SLCodec().getName());
			//a�adimos el servicio al agente
			dfd.addServices(sd);
			//guardamos los servicios que da el agente
		}
		System.out.println("he llegado,soy el agente1");
		
		try{
			DFService.register(this,dfd);
			
		}catch(FIPAException e){
			System.err.println("Agente "+getLocalName()+": "+e.getMessage());
		}
		
		parallel = new Parallel();
		
		this.addBehaviour(parallel);
	}
	
}