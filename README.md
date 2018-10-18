# Java-concurrent
Paquete de recopilación de los programas hechos durante las clase de Programación en Java concurrente incluyendo aplicaciones Hobbi. 
  # Print
   Corre un hilo en una interfaz grafica, permitiendo limpiar,etc.
  # MultConcurrent
   Calcula con N hilos una matriz N x N; con entrada seteada (Temporalmente).
  # Par_Impar
   Calcula un numero par e impar de una lista de *100* numeros de forma independiente (un hilo para cada uno) y los va contando; ademas determina cuando un numero termina en *2* y *3* (otro hilo independiente). Todo junto se ejecuta concurrentemente. 
  # Car_race
   Simula una carrera de autos establecidos como hilos independientemente el cual el limite es de *10* y con un maximo de distancia o tecnicamente el ciclo es de *20* por simplicidad y ajustes al tamano de la aplicacion definida.
  # Timer_task
   Crea temporalmente a nivel de consola una tarea o recordatorio el cual se ejecutara X veces durante un tiempo establecido. PRONTO UNA GUI para esta.
  # Fabrica_papel 
   La fabrica de papel consiste en que hay productor que va poniendo N cantidad de papel para llenar N cajas, mientras que el supervisor monitorea la finalizacion de cada caja, es decir el supervisor toma las cajas llenas. Todo esto a base de hilos donde el productor o persona es un arreglo de N hilos (por el simple hecho de que en una fabrica puede haber N personas), al igual supervisor, es un arreglo de N hilos (suponiendo que dicha fabrica pueda tener mas de un supervisor) y la fabrica en si tambien seria un arreglo de hilos (ya que puedo tener mas  de una fabrica). Por ahora funciona con los datos en salida consola, la GUI ya esta implementada pero aun le faltan detalles para mejorar la salidad.
  # Chat_room
   Este es un intento de chat a base de hilos pasando por un buffer antes de llegar al destinatario. Este desarrollo tiene fallas a la hora de poner el mensaje en el buffer y que el receptor lo reciba. Cuenta con GUI en cambio, presenta multiples errores.
   
  # Red
   Este paquete contiene aplicaciones el cual se llevan a cabo mediante Socket y posteriormente RMI. Contiene el _TalkServer_ y el _TalkClient_ que es un ejemplo basico de como funciona la comunicacion entre un servidor en red y un cliente. Se considera hacer una GUI para estas clase posteriormente.
