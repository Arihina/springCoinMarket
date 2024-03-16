# Digital currency exchange 
## functional requirements of the project
- User registration
- Viewing assets in the userDao's wallet
- Transfer of assets between users
- Putting assets up for sale
- Submitting an application for the purchase of assets
- Replenishment of an electronic wallet
- Withdrawal of money from an electronic wallet

## Done features

- Dto and Dao layers for user, wallet and coin models
- Controllers and services for user, wallet and coin models
- Saving user, wallet and coin models in memory 

## Planned
- Refactor:
    - Fix mapping paths in controller
    - Controller for registration users, with supporting wallet's service  
    - Fix names, data types (for classes and interfaces) and annotations in models
- Make:
    - New model for saving many user's wallets for different coins
    - Transfer conversion from services to a separate class (Dao -> Dto & Dto -> Dao)
    - Controller and service for depositing/ debiting funds from the wallet
