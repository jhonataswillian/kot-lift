# KtorFit

**KtorFit** is a high-performance, type-safe RESTful API designed for tracking gym workouts, exercises, and training volume. Built with **Modern Kotlin** and **Ktor**, this project demonstrates a clean, scalable backend architecture following the "Kotlin Way".

## Tech Stack

*   **Language:** [Kotlin](https://kotlinlang.org/) (JVM 21)
*   **Framework:** [Ktor Server](https://ktor.io/) (Netty Engine)
*   **Database:** [H2 Database](https://www.h2database.com/) (File-based Persistence)
*   **ORM:** [Exposed](https://github.com/JetBrains/Exposed) (Kotlin SQL Framework)
*   **Serialization:** Kotlinx Serialization (JSON)
*   **Architecture:** Route-Service-Repository Pattern with DTOs

## Key Features

*   **Workout Management:**
    *   Create, read, update, and delete workouts.
    *   **Pagination & Sorting:** List workouts with `page` and `limit` support, ordered by date.
    *   **Validation:** Enforces minimum duration (5 minutes).
*   **Exercise Tracking:**
    *   Add exercises to workouts with weight, sets, and reps.
    *   **Validation:** Enforces non-negative weights.
*   **Analytics:**
    *   Generates **Volume Reports** (Total Load = Weight * Sets * Reps) per workout.
    *   Detailed workout view including exercise list.
*   **Robust Error Handling:** Global exception handling using Ktor Status Pages.
*   **Configuration:** Database credentials externalized in `application.conf`.

## Getting Started

### Prerequisites
*   JDK 21+
*   Git

### Installation & Running

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/jhonataswillian/ktorfit.git
    cd ktorfit
    ```

2.  **Run the application:**
    ```bash
    ./gradlew run
    ```

The server will start at `http://0.0.0.0:8080`.

## API Endpoints

### Workouts
| Method | Endpoint | Description | Query Params |
| :--- | :--- | :--- | :--- |
| `GET` | `/workouts` | List all workouts (Paginated) | `?page=1&limit=10` |
| `POST` | `/workouts` | Create a new workout | - |
| `GET` | `/workouts/{id}` | Get workout details (with exercises) | - |
| `PUT` | `/workouts/{id}` | Update a workout | - |
| `DELETE` | `/workouts/{id}` | Delete a workout | - |
| `GET` | `/workouts/{id}/report` | **Get workout volume report** | - |

### Exercises
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/exercises` | Add an exercise |
| `DELETE` | `/exercises/{id}` | Remove an exercise |
| `GET` | `/workouts/{id}/exercises` | List exercises for a specific workout |

## Project Structure

```
src/main/kotlin/com/example
├── database/       # Database Tables (Schema)
├── dto/            # Data Transfer Objects (Request/Response)
├── models/         # Domain Models
├── plugins/        # Ktor Configuration (Routing, Serialization, DB, Monitoring)
├── repositories/   # Data Access Layer (Exposed Implementation)
├── routes/         # API Endpoints
└── services/       # Business Logic & Validation
```

---

Developed by **Jhonatas Willian**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/jhonataswillian/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/jhonataswillian)
[![Gmail](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:jhonatas.willian.dev@gmail.com)