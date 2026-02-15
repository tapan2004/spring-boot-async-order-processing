# Spring Boot Async Order Processing 🚀

A **production-grade asynchronous order processing system** built with Spring Boot using `@Async`, `ThreadPoolTaskExecutor`, and `CompletableFuture`.

This project demonstrates **non-blocking API design, parallel background processing, custom thread pool tuning, async exception handling, and scalable architecture** — similar to real-world backend systems used in e-commerce platforms.

---

## ✨ Features

- Non-blocking order processing API
- Parallel async task execution using `@Async`
- Custom `ThreadPoolTaskExecutor` (production tuned)
- `CompletableFuture` for async orchestration
- Graceful shutdown of async tasks
- Async exception handling
- Rejection policy to prevent crashes
- Structured logging with trackingId
- Clean and scalable service design

---

## 🧠 Async Flow

Client → Order API (Sync)
→ Payment Processing (Sync)

   → Async Tasks (Parallel)
       • Notify User
       • Assign Vendor
       • Packaging
       • Assign Delivery Partner
       • Dispatch Order

The API returns immediately while background tasks continue execution asynchronously.

---

## 🛠 Tech Stack

- Java 17+
- Spring Boot
- Spring Async (`@Async`)
- ThreadPoolTaskExecutor
- CompletableFuture
- Lombok
- Maven

---

## ⚙️ Thread Pool Configuration

| Property | Value |
|---------|-------|
| Core Pool Size | 5 |
| Max Pool Size | 20 |
| Queue Capacity | 500 |
| Keep Alive | 60s |
| Rejection Policy | CallerRunsPolicy |
| Graceful Shutdown | Enabled |

---

## ▶️ Run the Project

### Clone Repository

```bash
git clone https://github.com/tapan2004/spring-boot-async-order-processing.git
cd spring-boot-async-order-processing
Run Application
mvn spring-boot:run
Server starts at:

http://localhost:8080
📦 Test API
Create Order
POST /api/orders

{
  "productId": 1,
  "productName": "Laptop",
  "productType": "Electronics",
  "productQty": 1,
  "price": 75000
}
Sample Response
Order created successfully. TrackingId=xxxxx
Async tasks will continue in background (check logs).

📊 Example Logs
Payment completed for productId=1
Order processed successfully trackingId=abc123

User notified | thread=Async-1
Vendor assigned | thread=Async-2
Packing done | thread=Async-3
Delivery partner assigned | thread=Async-4
Order dispatched | thread=Async-2
🧪 Production Concepts Demonstrated
Non-blocking backend architecture

Parallel async execution

Custom thread pool tuning

Async error handling

Safe rejection handling

Graceful shutdown

Scalable background processing

🚀 Future Enhancements (Enterprise Level)
Kafka / RabbitMQ event-driven async

Retry + Dead Letter Queue

Idempotent processing

Circuit Breaker (Resilience4j)

Distributed async microservices

Async monitoring (Micrometer + Prometheus)

Docker & Kubernetes deployment

Async load testing

👨‍💻 Author
Tapan Manna
