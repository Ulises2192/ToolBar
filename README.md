# ToolBar
Ejemplo de como personalizar un Toolbar personalizado,  añadiendo iconos e implementar eventos de listener de los items del menú, ademas se implementa un Search Item para busquedas con sus metodos onQueryTextSubmit y onQueryTextChange

En el AdnroidManifest.xml se agrego la propiedad parentActivityName con la finalidad de indicar que el MainActivity es padre del SecondActivity, de este modo a la hora de presionar back en el Toolbar, Android sabe a que actividad debe regresar.
```xml
<activity android:name=".SecondSegundo"
    android:parentActivityName=".MainActivity">
</activity>
```
