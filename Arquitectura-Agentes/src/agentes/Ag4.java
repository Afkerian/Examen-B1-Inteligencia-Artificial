/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class Ag4 extends Agent{
    @Override
    protected void setup(){ addBehaviour(new Comportamiento());}

    class Comportamiento extends Behaviour{
        boolean terminado = false;

        CAR closet = new CAR();

        @Override
        public void action() {
            ACLMessage msj = blockingReceive();
            String idC = msj.getConversationId();

            if(idC.equalsIgnoreCase("COD3-4")){
                    String prediccion = msj.getContent();
                    System.out.println("La prediccion es: "+prediccion);
                    Mensajes.enviar(ACLMessage.INFORM, "Ag1",prediccion, "COD4-1", getAgent());
            }
        }

        @Override
        public boolean done() {
            return terminado;
        }
    }
}
