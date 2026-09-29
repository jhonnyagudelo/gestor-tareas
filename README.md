# Gestor de Tareas - Android Java

Proyecto académico Android desarrollado en Java y XML a partir del mockup de la primera entrega.

## Requisitos
- Android Studio (JDK 17 incluido/recomendado)
- Android SDK 35
- Gradle/Android Gradle Plugin según archivos del proyecto
- Dispositivo o emulador con Android 6.0 (API 23) o superior

## Ejecución
1. Abrir la carpeta `GestorTareasAndroid` en Android Studio.
2. Permitir que Gradle sincronice el proyecto.
3. Instalar SDK 35 si Android Studio lo solicita.
4. Ejecutar `app` en un emulador o dispositivo.

## Estructura funcional
- `MainActivity`: contenedor y navegación lateral.
- `PerfilFragment`: resumen de productividad y acceso al panel.
- `FotosFragment`: selector de imágenes del dispositivo.
- `VideoFragment`: selector y reproducción de video local.
- `WebFragment`: apertura de enlaces en navegador.
- `BotonesFragment`: creación, duplicado, descarte y persistencia local de una tarea.

No requiere permisos de almacenamiento porque usa el selector de documentos del sistema (`ACTION_OPEN_DOCUMENT`).
