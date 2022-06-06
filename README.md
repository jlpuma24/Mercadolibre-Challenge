# Mercadolibre Mobile Challenge.

El propósito del siguiente Desarrollo es desarrollar una App, nativa en Android, que utilice las APIs de Mercadolibre para permitirle a un usuario ver los detalles de un producto.

La App debe permitir la posibilidad de:

Realizar busquedas por medio de un campo de búsqueda.
Visualización de resultados de la búsqueda.
Visualizar el detalle de un producto seleccionado.

Para el desarrollo se usó el patrón arquitectónico MVVM, estandar propuesto por Google. Adicionalmente con el Patrón Repository e inyección de dependencias con Koin

## [Patrón Modelo – Vista – ModelView (MVVM)](https://developer.android.com/jetpack/docs/guide)

## [Android Jetpack](https://developer.android.com/jetpack)
Jetpack es un conjunto de bibliotecas, herramientas y guías para ayudar a los desarrolladores a escribir apps de alta calidad de forma más sencilla. Estos componentes te ayudan a seguir recomendaciones, te liberan de escribir código estándar y simplifican tareas complejas para que puedas enfocarte en el código 
que realmente te interesa.

Jetpack incluye bibliotecas de paquetes de androidx.* desglosadas de las API de la plataforma. Esto significa que ofrece retrocompatibilidad y se actualiza con mayor frecuencia que la plataforma de Android, de manera que siempre tendrás acceso a las mejores y más recientes versiones de los componentes de Jetpack.

### Bibliotecas de vinculación de datos parte de Android Jetpack

#### ViewModel

[ViewModel](https://developer.android.com/reference/androidx/lifecycle/ViewModel.html)
es una clase que se encarga de preparar y administrar los datos para una `Activity` o una `Fragment`. También maneja la comunicación de la Actividad / Fragmento con el resto de la aplicación (por ejemplo, llamando a las clases de lógica de negocios).

Un ViewModel siempre se crea en asociación con un ámbito (un fragmento o una actividad) y se conservará mientras el ámbito esté activo. Por ejemplo, si es una Actividad, hasta que se termine.

En otras palabras, esto significa que un ViewModel no se destruirá si su propietario se destruye por un cambio de configuración (por ejemplo, rotación). La nueva instancia del propietario se volverá a conectar al ViewModel existente.

El propósito de ViewModel es adquirir y mantener la información necesaria para una Actividad o un Fragmento. La Actividad o el Fragmento debería poder observar los cambios en el Modelo de vista. ViewModels generalmente expone esta información a través de un `LiveData` enlace de datos de Android. También puede usar cualquier construcción de observabilidad de su marco 
favorito.

La única responsabilidad de ViewModel es administrar los datos para la IU. **Nunca debe acceder a su jerarquía de vistas ni retener una referencia a la Actividad o al Fragmento**.

#### LiveData

[LiveData](https://developer.android.com/topic/libraries/architecture/livedata.html)
es una clase de retención de datos observable. A diferencia de una clase observable regular, LiveData está optimizada para ciclos de vida, lo que significa que respeta el ciclo de vida de otros componentes de las apps, como actividades, fragmentos o servicios. Esta optimización garantiza que LiveData solo actualice observadores de componentes de apps que tienen un 
estado de ciclo de vida activo.

LiveData considera que un observador, representado por la clase `Observer`, está en un estado activo si su ciclo de vida tiene el estado `STARTED` o `RESUMED`. LiveData solo notifica a los observadores activos sobre las actualizaciones. A los observadores inactivos registrados para observar objetos `LiveData` no se les notifica sobre los cambios.

Puedes registrar un observador sincronizado con un objeto que implementa la interfaz de `LifecycleOwner`. Esta relación permite quitar el observador cuando el estado del objeto Lifecycle correspondiente cambia a `DESTROYED`, lo que es particularmente útil para las actividades y los fragmentos porque pueden observar objetos `LiveData` de manera segura sin 
preocuparse por las pérdidas (se anula de inmediato la suscripción a las actividades y los fragmentos cuando se destruyen sus ciclos de vida).

LiveData evita Memory Leaks: Una pérdida de memoria ocurre cuando su código asigna memoria para un objeto, pero nunca lo desasigna. Esto puede suceder por muchas razones, no importa la causa, cuando se produce una pérdida de memoria, el recolector de basura cree que todavía se necesita un objeto porque otros objetos aún lo hacen referencia. Pero esas referencias deberían haberse borrado. La memoria asignada para los objetos filtrados actúa como un bloque inamovible, lo que obliga al resto de la aplicación a ejecutarse en lo que queda del montón. Esto puede causar frecuentes recolecciones de basura. Si la aplicación continúa perdiendo memoria, finalmente se quedará sin memoria y se bloqueará.

