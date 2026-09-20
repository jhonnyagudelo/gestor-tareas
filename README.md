# 📱 Gestor de Tareas — Mobile App (v0.1)

Aplicación móvil para la gestión integral de tareas, seguimiento de productividad y organización de recursos multimedia (fotos, videos y enlaces web) asociada al flujo de trabajo diario.

---

## 📌 Descripción del Proyecto

El **Gestor de Tareas** permite a los usuarios centralizar sus actividades cotidianas, supervisar métricas de cumplimiento mediante un resumen de productividad y enriquecer cada tarea vinculando recursos digitales esenciales (documentación, capturas y material audiovisual).

Diseñado con una arquitectura modular y una interfaz optimizada para dispositivos móviles (viewport base de 390 × 844 px).

---

## 🚀 Características Principales

- **Gestión de Tareas (CRUD):** Creación, edición, eliminación y cambio de estado de tareas.
- **Ciclo de Vida de Tareas:** Flujo de estados estructurado (`Pending` ➔ `Process` ➔ `Complete`).
- **Dashboard de Productividad:** Métricas en tiempo real con conteo de tareas pendientes, balance general e indicadores del día.
- **Riel de Navegación Vertical:** Acceso rápido y persistente a 5 secciones temáticas:
  1. 👤 **Perfil:** Resumen general de productividad, balance y acceso al panel principal.
  2. 🖼️ **Fotos:** Galería en cuadrícula (2 columnas) para adjuntar evidencias o capturas a tareas.
  3. 🎥 **Videos:** Reproductor integrado y lista de grabaciones vinculadas.
  4. 🌐 **Web:** Gestor de enlaces y accesos directos a documentación o tableros externos.
  5. 🔘 **Botones / Controles:** Panel de acciones rápidas (crear, pausar, duplicar o archivar tareas).

---

## 📐 Diseño y UI/UX

La interfaz sigue los lineamientos del documento de diseño inicial:

- **Resolución base:** 390 × 844 px (borde de 12 px, radios de tarjetas de 16–22 px, botones píldora de 24 px).
- **Tipografía:** Barlow Condensed (encabezados) y Barlow (cuerpo de texto).
- **Paleta de Colores:**
  - Cabecera: Degradado `#BFE0FF` a `#8FC7FF` con tipografía `#0B2B4D`.
  - Riel vertical: Ancho de 104 px sobre fondo `#EEF6FE`.
  - Estados visuales: Indicadores cromáticos para estados Activo, Pausado y Archivado.

---

## 🏗️ Arquitectura y Modelo de Datos (UML)

El sistema está modelado bajo principios orientados a objetos y patrones de separación de responsabilidades (UI, Controladores, Modelos y Almacenamiento):

### Modelo Conceptual (Clases Principales)

- **`Usuario`:** Maneja credenciales, categoría, avatar y perfil (`edit_profile()`, `view_summary()`).
- **`Task`:** Entidad central que encapsula título, descripción, prioridad, fecha de vencimiento (`due_date`) y estado.
- **`Photo` / `Video` / `Website`:** Entidades multimedia asociadas en relación `0..*` a una tarea específica.
- **`Session`:** Modela las vistas del riel de navegación (`profile`, `photos`, `video`, `website`, `buttons`).

### Flujos Clave Modelados

1. **Creación con Adjuntos:** Interacción coordinada entre la UI, `Controlador Tarea`, `Modelo Tarea` y capa de persistencia/almacenamiento.
2. **Cálculo de Métricas:** Consulta del `Controlador Resumen` hacia el modelo para calcular balances de tareas completadas vs. pendientes.

---

## 📂 Estructura del Repositorio

```text
├── docs/                   # Documentación de diseño y diagramas UML
│   ├── mockups/            # Wireframes y pantallas de la entrega inicial
│   └── uml/                # Diagramas de clases, secuencias, estados y actividades
├── src/
│   ├── assets/             # Iconos, fuentes y recursos gráficos
│   ├── components/         # Componentes reutilizables (Riel, Tarjetas, Botones)
│   ├── controllers/        # Controladores (TaskController, SummaryController)
│   ├── models/             # Modelos de datos (Task, User, Media)
│   ├── navigation/         # Enrutamiento entre secciones
│   └── views/              # Pantallas (Perfil, Fotos, Video, Web, Controles)
└── README.md
```
