CREATE TABLE list_owners
(
    owner_id     BIGSERIAL PRIMARY KEY,
    first_name   CHAR NOT NULL,
    last_name  CHAR NOT NULL,
    owner_phone        CHAR NOT NULL,
    first_visit_date CHAR NOT NULL
);
