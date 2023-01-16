package contenedores;

import agentes.Ag1;
import agentes.Ag2;
import agentes.Ag3;
import agentes.Ag4;
import agentes.AlgoritmosGeneticos;
import agentes.AnnClasificacion;
import agentes.AnnRegresion;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import GUI.GUI_conexion;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Moya
 */
public class Contenedor {
    private AgentContainer agentContainer;

    public void crearContenedor(){

        jade.core.Runtime runtime = jade.core.Runtime.instance(); // Esto es un proceso como tal para el contenedor
        Profile profile = new ProfileImpl(null, 1099, null); // null : escoge aleatorio
        runtime.createMainContainer(profile);
        agentContainer = runtime.createAgentContainer(profile);
        agregarAgentes();
        // No ICP active que el puerto ya esta siendo usado

    }

    private void agregarAgentes()  { // try catch
        /**
         * Se crea el Agente 3, luego el 2 y por ultimo el 1 con el proposito de que siempre debe exitir el que recibe
         * los mensajes antes del que los envia
         */
        try{
            GUI_conexion gui  = new GUI_conexion();
            agentContainer.createNewAgent("Ag3", Ag3.class.getName(), new Object[]{this,1}).start();
            agentContainer.createNewAgent("AlgoritmosGeneticos", AlgoritmosGeneticos.class.getName(), new Object[]{this,1}).start();
            agentContainer.createNewAgent("AnnClasificacion", AnnClasificacion.class.getName(), new Object[]{this,1}).start();
            agentContainer.createNewAgent("AnnRegresion", AnnRegresion.class.getName(), new Object[]{this,1}).start();
            agentContainer.createNewAgent("Ag2", Ag2.class.getName(), new Object[]{this,1}).start();
            agentContainer.createNewAgent("Ag3", Ag3.class.getName(), new Object[]{this,1}).start();
            agentContainer.createNewAgent("Ag4", Ag4.class.getName(), new Object[]{this,1}).start();
            agentContainer.createNewAgent("Ag1", Ag1.class.getName(), new Object[]{gui}).start();
            
            //agentContainer
            // El setup nunca lo llamo explicitamente, con startp lo invoco
        }catch(StaleProxyException ex){
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
