package workclass;



import jade.content.lang.sl.SLCodec;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;


public class Agente extends Agent {

	private static final long serialVersionUID = 1L;
	protected Parallel parallel;
	
	
	// conexiones de los agentes
	
	private String [] conexionagente1	=	{"Español"};
	private String [] conexionagente2	= 	{"Francés", "Portugués"};
	private String [] conexionagente3	= 	{"Alemán","Inglés"};
	private String [] conexionagente4	= 	{"Español","Italiano"};
	private String [] conexionagente5	= 	{"Francés","Italiano"};
	
	
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
		
		
		switch(nombre) {
		
		case "agente1":
			conexiones= new String [conexionagente1.length];
			for(i=0;i<conexionagente1.length;i++)
				conexiones[i]=conexionagente1[i];
			break;
		case "agente2":
			conexiones= new String [conexionagente2.length];
			for(i=0;i<conexionagente2.length;i++)
				conexiones[i]=conexionagente2[i];
			
			break;
		case "agente3":
			conexiones= new String [conexionagente3.length];
			for(i=0;i<conexionagente3.length;i++)
				conexiones[i]=conexionagente3[i];
			break;
		case "agente4":
			conexiones= new String [conexionagente4.length];
			for(i=0;i<conexionagente4.length;i++)
				conexiones[i]=conexionagente4[i];
			break;
		case "agente5":
			conexiones= new String [conexionagente5.length];
			for(i=0;i<conexionagente5.length;i++)
				conexiones[i]=conexionagente5[i];
			break;
		
			
		}
		
		// Bucle metiendo los idiomas del presidente
		
		
			for(i=0;i<conexiones.length;i++) {
				
			sd= new ServiceDescription();
			//El nombre sera el de cada agente
			sd.setName(nombre);
			//El tipo sean los servicios que tiene cada agente
			sd.setType(conexiones[i]);
			//La ontologia no se va a usar en este caso
			sd.addOntologies("Ontologia");
	
			sd.addLanguages(new SLCodec().getName());
			//añadimos el servicio al agente
			dfd.addServices(sd);
			//guardamos los servicios que da el agente
		}
		
		
		try{
			DFService.register(this,dfd);
			
		}catch(FIPAException e){
			System.err.println("Agente "+getLocalName()+": "+e.getMessage());
		}
		
		parallel = new Parallel();
		
		this.addBehaviour(parallel);
	}
	
}