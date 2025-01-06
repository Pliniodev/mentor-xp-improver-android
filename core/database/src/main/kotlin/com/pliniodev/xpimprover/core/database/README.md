# Room Database Example

This module provides a straightforward example of how to integrate the Room database into your project.

## Components

### Entity: `User`
- Fields:
    - `id`: Primary key
    - `name`: A simple field to store the user's name

### DAO: `UserDao`
- Methods:
    1. **`insert`**: Adds a single `User` record to the database.
    2. **`insertAll`**: Inserts multiple `User` records simultaneously.

### Database: `AppDatabase`
- Name: `AppDatabase`
- Version: `1`

## Summary
This example demonstrates the basic setup and usage of Room, including entity definition, DAO creation, and database initialization.
