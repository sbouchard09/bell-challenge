# Installation instructions
1. Clone the repository: `git clone https://github.com/sbouchard09/bell-challenge.git`
2. Open the project in the IDE (i.e. IntelliJ). In the IDE terminal, run the command `mvn clean spring-boot:run`
3. Open the terminal to use the API with `curl` as described in the [wiki](https://github.com/sbouchard09/bell-challenge/wiki/Using-the-API). Alternatively, navigate to `localhost:8080` to run the commands in a browser

# Bell Challenge
## Challenge
Produce a REST API that allows the following :
- List a catalog of products.
- Display the details of a given product.
- Add a product to a shopping cart.
- Remove a product from the cart.
- List the content of the cart.

## Constraints
- Use an in-memory SQL database. Something like H2 or SQL Lite.
- Use Spring Boot as a Framework
- Provide a clear « Readme » allowing for easy installation.

## Evaluation
We will be looking at the following points :
- Quality and clarity of code.
- Application architecture and design patterns.
- How much of the challenge you managed to implement
