# Digital currency exchange 
## Functional requirements of the project
- User registration
- Viewing assets in the user's wallet
- Transfer of assets between users
- Putting assets up for sale
- Submitting an application for the purchase of assets
- Replenishment of an electronic wallet
- Withdrawal of money from an electronic wallet

## Done features

- Dto and Dao layers for user, wallet and coin models
- Controllers and services for user, wallet and coin models
- Saving user, wallet and coin models in memory 

## Planned (Done)
- Refactor:
    - Fix mapping paths in controllers
    - Controller for registration users, with supporting wallet's service  
    - Fix names, data types (for classes and interfaces) and annotations in models
- Make:
    - New model for saving many user's wallets for different coins
    - Transfer conversion from services to a separate class (Dao -> Dto & Dto -> Dao)
    - Controller and service for depositing / debiting funds from the wallet

## Planned (Done)
- Make:
  - connect the database

## Planned (Done)
- Make:
  - the system for receiving the current exchange rate

## Planned
- Refactor:
  - Add a new entity (and repository) - trading pairs of cryptocurrencies to the dollar
  - Fill new entity and Coin entity
  - Service with cryptocurrency
- Make:
  - Currency exchange between users