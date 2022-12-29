create table bank
(
    id                 uuid NOT NULL PRIMARY KEY,
    name               varchar(50),
    bank_offices_count int,
    atms_count         int,
    employees_count    int,
    clients_count      int,
    rating             float,
    amount             numeric(19, 4),
    interest_rate      float
);

create table bank_office
(
    id                 uuid NOT NULL PRIMARY KEY,
    name               varchar(50),
    address            varchar(150),
    status             varchar(50),
    is_atm_possible    boolean,
    atms_count         int,
    is_credit_possible boolean,
    cash_in            boolean,
    cash_out           boolean,
    bank_id            UUID
        CONSTRAINT fk_bank_id REFERENCES bank,
    amount             numeric(19, 4),
    rent_price         numeric(19, 4)
);

create table employee
(
    id              uuid NOT NULL PRIMARY KEY,
    first_name      varchar(50),
    last_name       varchar(50),
    middle_name     varchar(50),
    birth_date      date,
    position        varchar(50),
    bank_id         UUID
        CONSTRAINT fk_bank_id REFERENCES bank,
    is_remote       boolean,
    bank_office_id  UUID
        CONSTRAINT fk_bank_office_id REFERENCES bank_office,
    is_issue_credit boolean,
    pay             numeric(19, 4)
);

create table bank_atm
(
    id               uuid NOT NULL PRIMARY KEY,
    name             varchar(50),
    address          varchar(150),
    status           varchar(50),
    bank_id          UUID
        CONSTRAINT fk_bank_id REFERENCES bank,
    employer_id      UUID
        CONSTRAINT fk_employer_id REFERENCES employee,
    cash_in          boolean,
    cash_out         boolean,
    amount           numeric(19, 4),
    maintenance_cost numeric(19, 4)
);

create table client
(
    id             uuid NOT NULL PRIMARY KEY,
    first_name     varchar(50),
    last_name      varchar(50),
    middle_name    varchar(50),
    place_work     varchar(50),
    monthly_income numeric(19, 4),
    credit_rating  int
);

create table payment_account
(
    id        uuid NOT NULL PRIMARY KEY,
    client_id UUID
        CONSTRAINT fk_client_id REFERENCES client,
    bank_id   UUID
        CONSTRAINT fk_bank_id REFERENCES bank,
    amount    numeric(19, 4)
);

create table credit_account
(
    id                 uuid NOT NULL PRIMARY KEY,
    client_id          UUID
        CONSTRAINT fk_client_id REFERENCES client,
    bank_id            UUID
        CONSTRAINT fk_bank_id REFERENCES bank,
    start_date         date,
    end_date           date,
    number_months      int,
    amount             numeric(19, 4),
    monthly_payment    numeric(19, 4),
    interest_rate      float,
    employer_id        UUID
        CONSTRAINT fk_employer_id REFERENCES employee,
    payment_account_id UUID
        CONSTRAINT fk_payment_account_id REFERENCES payment_account
);

create table client_banks
(
    banks_id   UUID
        CONSTRAINT fk_bank_id REFERENCES bank,
    clients_id UUID
        CONSTRAINT fk_client_id REFERENCES client
)