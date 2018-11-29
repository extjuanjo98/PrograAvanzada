package sastre;


import java.util.Random;

import modelo.Mensajero;
import modelo.Paquete;
import modelo.Router;
import modelo.Singletone;


import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class Utils {
	static Singletone st = new Singletone();
	static Mensajero m = new Mensajero(null, null);
	static int num = -2;
	
	
	////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////
	
	/* public static void enviarMensaje (Agent agent, AID agente_E, Object objeto){
	    	
	      
	        try{
	            	
	            ACLMessage aclMessage = new ACLMessage(ACLMessage.REQUEST);
	            	
		        aclMessage.addReceiver(agente_E);
	            	
	            aclMessage.setOntology("ontologia");
	            //el lenguaje que se define para el servicio
	            aclMessage.setLanguage(new SLCodec().getName());
	            //el mensaje se transmita en XML
	            aclMessage.setEnvelope(new Envelope());
				//cambio la codificacion de la carta
				aclMessage.getEnvelope().setPayloadEncoding("ISO8859_1");
	            //aclMessage.getEnvelope().setAclRepresentation(FIPANames.ACLCodec.XML); 
	        	aclMessage.setContentObject((Serializable)objeto);
	        	agent.send(aclMessage);
	        		
	        }catch(IOException e){
	        	
	            //JOptionPane.showMessageDialog(null, "Agente "+getLocalName()+": "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	            e.printStackTrace();
	        }
	    }
	    

*/
	
	
	
		//public static guardar mensaje
		//////////////////////////////////////////////////////////////////////
		// TURNOS/////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////
		public static void packAleatorio(){
			if(num<0){
				Random genA = new Random();
				num= 1+ genA.nextInt(5);
			}
		}
		public static int comprobarTurno(){
			return num;
		}
		public static void recogerTurno(){
			num=0;
		}
		public static void resetearTurno(){
			num=-1;
		}
		
		/////////////////////////////////////////////////////////////////////
		//Singletone/////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////
		public static Router getRouter(String router){
			Router rut;
			rut=Utils.getRouter1();
			if(rut.getIdSala().equals(router)){
				return rut;
			}
			rut=Utils.getRouter2();
			if(rut.getIdSala().equals(router)){
				return rut;
			}
			rut=Utils.getRouter3();
			if(rut.getIdSala().equals(router)){
				return rut;
			}
			rut=Utils.getRouter4();
			if(rut.getIdSala().equals(router)){
				return rut;
			}
			return null;
		}
		public static void setRouter(Router rut) {
			if(rut.getIdSala().equals(Utils.getRouter1().getIdSala())){
				Utils.setRouter1(rut);
			}else if(rut.getIdSala().equals(Utils.getRouter2().getIdSala())){
				Utils.setRouter2(rut);
			}else if(rut.getIdSala().equals(Utils.getRouter3().getIdSala())){
				Utils.setRouter3(rut);
			}else if(rut.getIdSala().equals(Utils.getRouter4().getIdSala())){
				Utils.setRouter4(rut);
			}
		}
		public static Router getRouter1(){
			return st.getRouter1();
		}
		public static void setRouter1(Router router1){
			st.setRouter1(router1);
		}
		public static Router getRouter2(){
			return st.getRouter2();
		}
		public static void setRouter2(Router router2){
			st.setRouter1(router2);
		}
		public static Router getRouter3(){
			return st.getRouter3();
		}
		public static void setRouter3(Router router3){
			st.setRouter1(router3);
		}
		public static Router getRouter4(){
			return st.getRouter4();
		}
		public static void setRouter4(Router router4){
			st.setRouter1(router4);
		}
		public static Router mayorCapacidad(){
			Router route = new Router();
			route=st.getRouter1();
			if(route.getCapacidad()<st.getRouter2().getCapacidad()){
				route=st.getRouter2();
			}
			if(route.getCapacidad()<st.getRouter3().getCapacidad()){
				route=st.getRouter3();
			}
			if(route.getCapacidad()<st.getRouter4().getCapacidad()){
				route=st.getRouter4();
			}
			
			return route;
		}
		//////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////
		public static DFAgentDescription [] buscarAgentes(Agent agent, String tipo){// tipo pasamos nombres de router
	    	
	        //indico las características el tipo de servicio que quiero encontrar
	        DFAgentDescription template=new DFAgentDescription();
	        ServiceDescription templateSd=new ServiceDescription();
	        templateSd.setType(tipo); //como define el tipo el agente coordinador tambien podriamos buscar por nombre
	        template.addServices(templateSd);
	        
	        SearchConstraints sc = new SearchConstraints();
	        sc.setMaxResults(Long.MAX_VALUE);
	        
	        try{
	            DFAgentDescription [] results = DFService.search(agent, template, sc);
	            
	            return results;
	            
	        }catch(FIPAException e){
	        	
	            //JOptionPane.showMessageDialog(null, "Agente "+getLocalName()+": "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        	e.printStackTrace();
	        }
	        
	        return null;
	}
		
		public static Paquete generarPaquete() {
			Random genA = new Random();
			int i= 1+ genA.nextInt(60);
			Paquete pack = new Paquete(i,null);
			return pack;
		}
		public static String enviarPack(Paquete pack) {
			Random genA = new Random();
			int id = 1+ genA.nextInt(10000);
			m.setIdPaquete(Integer.toString(id));
			m.setPack(pack);
			return Integer.toString(id);
		}
		public static Paquete recogerPack(String id) {
			if(id.equals(m.getIdPaquete())){
				return m.getPack();
			}
			return null;
		}
		public static Paquete getPaquete(){
			return m.getPack();
		}
		


}	