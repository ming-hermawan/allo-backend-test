# Allo Bank Backend Developer Take-Home Test

**NOTE:**  
Source code inside ***allobank*** folder.  

## API List

* /api/finance/data/latest_idr_rates
    Fetch the latest working day's Rupiah rate

* /api/finance/data/????-??-??...
    Retrieve rates for a specific date.
    Example:
    * /api/finance/data/2026-01-01
    * /api/finance/data/2026-01-01..2026-01-02
    * /api/finance/data/2026-01-01..2026-01-02?from=IDR&to=USD

* /api/finance/data/supported_currencies
    Get supported currency symbols and their full names.

## Installation

### With Docker
Dockerfile already included in this repository. If Docker is already installed, just run:

```
docker build -t allobank .;
docker run -d --name allobank -p 8080:8080 allobank;
```
NOTE: Running at port 8080.

### From source

#### Prerequisites

* JDK with Java 21
* Maven

#### Run

1. `cd allobank`
2. `./mvnw test`
3. `./mvnw spring-boot:run`
NOTE: Running at port 8080.
