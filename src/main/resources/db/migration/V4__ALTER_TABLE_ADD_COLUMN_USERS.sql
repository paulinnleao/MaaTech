ALTER TABLE USERS
ADD COLUMN role VARCHAR(10) NOT NULL,
ADD CONSTRAINT check_role CHECK (role IN ('ADMIN', 'USER'));