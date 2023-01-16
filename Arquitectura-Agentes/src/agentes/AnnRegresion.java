
package agentes;

import claseCAR.CAR;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alejandro Moya
 */
public class AnnRegresion extends Agent{
    @Override
    protected void setup(){ addBehaviour(new Comportamiento());}

    class Comportamiento extends Behaviour{
        boolean terminado = false;

        CAR closet = new CAR();

        @Override
        public void action() {
            ACLMessage msj = blockingReceive();
            try {
                closet=(CAR)msj.getContentObject();
                String paramentros = closet.toString();
                System.out.println(paramentros);
                String cmd = "python src/python/regresionModel.py " + paramentros;
                Process process = Runtime.getRuntime().exec(cmd);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String resultado = null;
                String prediccion = "";
                while ((resultado = reader.readLine())!=null){
                    prediccion = resultado;
                    try {
                        if (Double.parseDouble(resultado) > 0) {
                            break;
                        }
                    }catch (Exception e){
                    }
                }
                System.out.println("ES: " + prediccion);
                Mensajes.enviar(ACLMessage.INFORM, "Ag3", prediccion, "CODAR-3", getAgent());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (UnreadableException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public boolean done() {
            return terminado;
        }
    }
}
