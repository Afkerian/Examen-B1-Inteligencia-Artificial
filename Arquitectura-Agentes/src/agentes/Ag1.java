
package agentes;
import GUI.GUI_conexion;
import claseCAR.CAR;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
/**
 *
 * @author Alejandro Moya
 */
public class Ag1 extends Agent{
    
    @Override
    protected void setup(){ addBehaviour(new Comportamiento());}

    class Comportamiento extends Behaviour{
        boolean terminado = false;

        CAR closet = new CAR();

        @Override
        public void action() {
            GUI_conexion gui = (GUI_conexion) getArguments()[0];
            gui.setVisible(true);

            if(gui.isBotonInsertar()){
                closet =gui.getCloset();
                System.out.println("Agente 1: ");
                Mensajes.enviarS(ACLMessage.INFORM, "Ag2", gui.getCloset(), "COD1-2", getAgent());
                gui.setBotonInsertar(false);
            }
            ACLMessage msj = blockingReceive();
            String idC = msj.getConversationId();

            if(idC.equalsIgnoreCase("COD4-1")){
                    String prediccion = msj.getContent();
                    System.out.println("La prediccion es: "+prediccion);
                    gui.setTxtArea("");
                    gui.setTxtArea("Prediccion: "+prediccion);
            }
        }
        @Override
        public boolean done() {
            return terminado;
        }
    }
}
