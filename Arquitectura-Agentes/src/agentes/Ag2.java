
package agentes;

import claseCAR.CAR;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
/**
 *
 * @author aleja
 */
public class Ag2 extends Agent{
    @Override
    protected void setup(){ addBehaviour(new Comportamiento());}

    class Comportamiento extends Behaviour{
        boolean terminado = false;

        CAR closet = new CAR();

        @Override
        public void action() {
            ACLMessage msj = blockingReceive();
            String idC = msj.getConversationId();
            if(idC.equalsIgnoreCase("COD1-2")){
                try {
                    closet=(CAR)msj.getContentObject();
                    String paramentros = closet.toString();
                    System.out.println(paramentros);
                    Mensajes.enviarS(ACLMessage.INFORM, "AnnRegresion", paramentros, "COD2-AR", getAgent());
                    Mensajes.enviarS(ACLMessage.INFORM, "AnnClasificacion", paramentros, "COD2-AC", getAgent());
                    //Se le manda lo mismo al AG y luego se hace un split
                    Mensajes.enviarS(ACLMessage.INFORM, "AlgoritmosGeneticos", paramentros, "COD2-AG", getAgent());    
                } catch (UnreadableException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        @Override
        public boolean done() {
            return terminado;
        }
    }
}
