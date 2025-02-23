# Recipe Matcher Backend

## Project Description
Recipe Matcher is a Spring Boot application that helps users find recipes based on the ingredients they have available.

### How It Works:
1. Users input their available ingredients
2. System finds recipes that can be made with these ingredients
3. Matching recipes are displayed to the user

### Core Components:
- **Ingredient**: Stores basic ingredient information (name, type)
- **Recipe**: Contains recipes and their required ingredients
- **RecipeIngredientMatch**: Matches available ingredients with recipes

### Technologies:
- Java 17
- Spring Boot
- H2 Database
- JPA/Hibernate

## License
MIT 