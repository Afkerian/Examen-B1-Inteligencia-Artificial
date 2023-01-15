# Examen-B1-Inteligencia-Artificial
Exame B1

Agente 1 obtiene datos de la GUI, mediante un object envía al agente 2, el agente 2 separa los datos necesarios tanto para el agente ANN-R, agente ANN-C y AG, pasándoles como object, el agente ANN-R invoca a la red neuronal para predecir el número de islas necesarias y la información es enviada por string al agente 5, agente ANN-C invoca a la red neuronal para predecir el número si la cantidad de islas son muchas, pocas o casi nada, el agente AG obtiene del AG las 10 mejores configuraciones para ganar el juego (leyendo el csv y los parámetros llegan por medio de la GUI), esta lista la envía al agente 3 como object (lo mas importante el link de la primera columna). Cuando el agente 3 obtenga los 3 mensajes envía al agente 4 la información por object, el agente 4 compara todos los resultados de la siguiente manera y el resultado se enviará por object al agente 1:

-Si las islas son mucho entonces:

Enviar el número de islas predichas por el agente ANN-R y enviar la lista de las mejores islas en base a los parámetros.

-Si las islas son poco:

Enviar el número de islas predichas por el agente ANN-R, enviar la lista de las mejores islas en base a los parámetros e indicar que son pocas islas para ganar.

-Si las islas es casi nada:

Enviar el número de islas predichas por el agente ANN-R e indicar que casi no hay nada de islas para ganar el juego con la configuración establecida.

esta información es presentada por mensaje al usuario final.
 
 ---
 
 Rubrica:

Arquitectura Agentes: 10%

ANN: 20%

AG: 20%

Integración: 50%

Entregables:

src

.ipynb dos archivos

.py

.h5 2 modelos

.pkc (scaler) 2 archivos


