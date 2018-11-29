package control;

import java.io.IOException;
import java.io.Serializable;

import sastre.Utils;

import jade.content.lang.sl.SLCodec;
import jade.core.Agent;
import jade.domain.FIPAAgentManagement.Envelope;
import jade.lang.acl.ACLMessage;

public class Send {

	public static void enviarMensaje(Agent agent, Object objeto)
    {
        
        try
        {
            	ACLMessage aclMessage = new ACLMessage(ACLMessage.REQUEST);
            	
            	//for(int i=0;i<dfd.length;i++)
	        		aclMessage.addReceiver(Utils.getPaquete().getReceptor().getName());
            	
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
            
        }
        catch(IOException e)
        {
            //JOptionPane.showMessageDialog(null, "Agente "+getLocalName()+": "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

}
