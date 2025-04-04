CREATE SCHEMA IF NOT EXISTS contacts_schema;

CREATE TABLE IF NOT EXISTS contacts_schema.contact (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(255) NOT NULL
);
