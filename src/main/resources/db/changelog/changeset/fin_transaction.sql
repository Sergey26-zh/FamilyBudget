CREATE TABLE financial_transaction
(
    id BIGINT PRIMARY KEY NOT NULL,
    amount DOUBLE PRECISION,
    date TIMESTAMP,
    user_id BIGINT NOT NULL,
    transaction_type_id BIGINT NOT NULL,
    transaction_category_id BIGINT NOT NULL,
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES family_member (id) ON DELETE CASCADE,
    CONSTRAINT fk_transaction_type_id FOREIGN KEY (transaction_type_id) REFERENCES transaction_type (id) ON DELETE CASCADE,
    CONSTRAINT fk_transaction_category_id FOREIGN KEY (transaction_category_id) REFERENCES transaction_category (id) ON DELETE CASCADE
);