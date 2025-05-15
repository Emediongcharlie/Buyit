CREATE TABLE farmer (
                        id SERIAL PRIMARY KEY,
                        first_name VARCHAR(50) NOT NULL,
                        last_name VARCHAR(50) NOT NULL,
                        email VARCHAR(50) UNIQUE NOT NULL,
                        password VARCHAR(50) NOT NULL,
                        phone_number VARCHAR(11),
                        address TEXT,
                        farm_name VARCHAR(50),
                        bio TEXT,
                        verification_status VARCHAR(50),

                        customer_id INTEGER,
                        CONSTRAINT fk_customer
                            FOREIGN KEY (customer_id)
                                REFERENCES customer(id)
                                ON DELETE SET NULL
);
