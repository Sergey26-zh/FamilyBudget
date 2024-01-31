ALTER TABLE transaction_type
    ADD COLUMN category_id BIGINT;

ALTER TABLE transaction_type
    ADD CONSTRAINT fk_transaction_type_category
    FOREIGN KEY (category_id)
    REFERENCES transaction_category(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE;