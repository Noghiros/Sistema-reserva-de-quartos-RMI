# Sistema de Reserva de Quartos com Java RMI

Este projeto implementa um sistema **cliente/servidor distribuído** utilizando **Java RMI (Remote Method Invocation)** para reserva de quartos de hotel.  
O servidor gerencia os quartos disponíveis, enquanto os clientes podem consultar, reservar e listar hóspedes remotamente.

---

## 🏨 Funcionalidades

### Métodos remotos disponíveis para os clientes:

- **listagem**  
  Exibe a quantidade de quartos disponíveis em cada tipo.

- **reserva <tipo> <nome>**  
  Reserva um quarto do tipo informado e registra o nome do hóspede.

- **hospede**  
  Lista todos os hóspedes cadastrados.

---

## 🛏️ Tipos de Quartos

| Tipo | Descrição                | Quantidade | Preço |
|------|---------------------------|------------|--------|
| 0    | Individual                | 10         | R$ 100 |
| 1    | Duplo (padrão)            | 20         | R$ 150 |
| 2    | Duplo (premium)           | 5          | R$ 200 |
| 3    | Triplo                    | 3          | R$ 250 |
| 4    | Quádruplo                 | 2          | R$ 300 |

---

## 🧱 Estrutura do Projeto

- `GerenciadorQuartos.java` — Interface remota (RMI)
- `HotelServer.java` — Servidor RMI
- `HotelServerImpl.java` — Implementação da interface
- `HotelClient.java` — Cliente RMI
- `build.xml` — Arquivo do Ant

---

## 🚀 Como Executar com Ant

### 1. Compile o projeto:

