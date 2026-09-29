# Gestor de Tareas - Android

Aplicación móvil nativa para Android desarrollada en Java y XML. Implementa una arquitectura basada en una actividad principal con navegación lateral (*Navigation Rail*) y reemplazo dinámico de fragmentos, integrando persistencia local y manejo de contenido multimedia mediante el *Storage Access Framework* (SAF).

---

## Características principales

- **Navegación por Navigation Rail:** `MainActivity` gestiona la carga dinámica de fragmentos en un contenedor principal sin recrear la actividad.
- **Panel de control y resumen:** `PerfilFragment` presenta métricas de productividad y accesos directos al flujo de trabajo.
- **Gestión y ciclo de vida de tareas:** `BotonesFragment` permite crear, previsualizar, duplicar y descartar tareas, clasificándolas por estados (`ACTIVO`, `PAUSADO`, `ARCHIVADO`).
- **Persistencia local:** Almacenamiento del estado y la última tarea gestionada a través de `SharedPreferences`.
- **Integración multimedia segura:**
  - `FotosFragment`: Selección y visualización de imágenes locales.
  - `VideoFragment`: Selección y reproducción de video local con controles (`MediaController`).
  - Ambas funciones utilizan `ACTION_OPEN_DOCUMENT`, eliminando la necesidad de solicitar permisos peligrosos de lectura de almacenamiento.
- **Integración web externa:** `WebFragment` gestiona intents implícitos (`ACTION_VIEW`) para abrir recursos y documentación en el navegador predeterminado del sistema.

---

## Tecnologías y componentes

| Parámetro | Valor / Versión |
| :--- | :--- |
| **Lenguaje** | Java |
| **Interfaz gráfica** | XML nativo (Layouts y Drawables personalizados) |
| **Compile SDK** | 35 (Android 15) |
| **Target SDK** | 35 |
| **Min SDK** | 23 (Android 6.0 Marshmallow) |
| **Build System** | Gradle (Android Gradle Plugin) |
| **Persistencia** | `SharedPreferences` |

---

## Estructura del proyecto

```text
gestor-tareas/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── AndroidManifest.xml
│   │       ├── java/com/universidad/gestortareas/
│   │       │   ├── MainActivity.java      # Actividad principal y enrutamiento lateral
│   │       │   ├── PerfilFragment.java    # Métricas y resumen de usuario
│   │       │   ├── BotonesFragment.java   # Creación, persistencia y estados de tareas
│   │       │   ├── FotosFragment.java     # Selector y renderizado de imágenes (SAF)
│   │       │   ├── VideoFragment.java     # Selector y reproducción de video (SAF)
│   │       │   └── WebFragment.java       # Lanzador de intents para enlaces web
│   │       └── res/
│   │           ├── drawable/              # Fondos y formas vectoriales personalizadas
│   │           ├── layout/                # Vistas XML de la actividad y fragmentos
│   │           └── values/                # Colores, estilos y cadenas de texto
│   └── build.gradle                       # Configuración y dependencias del módulo app
├── build.gradle                           # Configuración raíz de compilación
├── settings.gradle                        # Definición del proyecto y repositorios
└── README.md
```

---

## Requisitos previos

- **Android Studio:** Ladybug (2024.2.1) o superior recomendado.
- **JDK:** Java Development Kit 17.
- **Android SDK:** Plataforma SDK 35 instalada.
- **Dispositivo o Emulador:** Dispositivo físico o AVD con Android 6.0 (API 23) o superior.

---

## Compilación y ejecución

### Desde Android Studio

1. Clonar el repositorio:
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   ```
2. Abrir la carpeta raíz del proyecto en Android Studio.
3. Esperar la sincronización de Gradle (*Sync Project with Gradle Files*).
4. Seleccionar la configuración de ejecución `app` y el dispositivo destino.
5. Presionar **Run** (`Shift + F10` o el botón de ejecución).

### Desde la terminal (Gradle Wrapper)

- **Compilar APK de depuración:**
  ```bash
  ./gradlew assembleDebug
  ```
  El archivo generado se ubicará en `app/build/outputs/apk/debug/app-debug.apk`.

- **Instalar directamente en dispositivo conectado:**
  ```bash
  ./gradlew installDebug
  ```

---

## Seguridad y permisos

La aplicación hace uso deliberado de las APIs de **Storage Access Framework (SAF)** mediante `Intent.ACTION_OPEN_DOCUMENT`. Esta decisión de diseño garantiza que:
1. El usuario mantenga control explícito sobre los archivos seleccionados.
2. No se requieran permisos invasivos como `READ_EXTERNAL_STORAGE` o `READ_MEDIA_*` en el `AndroidManifest.xml`.
3. La aplicación cumpla con las políticas de privacidad y almacenamiento seguro de Android moderno.
