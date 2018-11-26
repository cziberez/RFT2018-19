ALTER TABLE food ADD COLUMN ingridience NUMERIC (19,0) REFERENCES ingridence(id);
ALTER TABLE ingridence ADD COLUMN food NUMERIC (19,0) REFERENCES food(id);