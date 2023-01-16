/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class Ag3 extends Agent{
    @Override
    protected void setup(){ addBehaviour(new Comportamiento());}

    class Comportamiento extends Behaviour{
        boolean terminado = false;
        
        int contador = 0;
        @Override
        public void action() {
            
            ACLMessage msj = blockingReceive();
            String idC = msj.getConversationId();
            String prediccion1 = "";
            String prediccion2 = "";
            String prediccion3 = "";
            
            if(idC.equalsIgnoreCase("CODAC-3")){
                contador++;
                prediccion1 = msj.getContent();
            }
            if(idC.equalsIgnoreCase("CODAR-3")){
                contador++;
                prediccion2 = msj.getContent();
            }
            if(idC.equalsIgnoreCase("CODAG-3")){
                contador++;
                prediccion3 = msj.getContent();
            }
            
            if(contador==3){
                //Cuando es igual a 3 envia el mensaje al Agente 4
                String prediccion = prediccion3 + prediccion2 + prediccion1;
                Mensajes.enviar(ACLMessage.INFORM, "Ag4",prediccion, "COD3-4", getAgent());
            }
        }
        @Override
        public boolean done() {
            return terminado;
        }
    }
    
}
