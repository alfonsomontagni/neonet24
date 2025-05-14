-- Creazione tabella books
CREATE TABLE books (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  isbn VARCHAR(20) NOT NULL UNIQUE,
  title VARCHAR(255),
  authors VARCHAR(255),
  publisher VARCHAR(255),
  published_date VARCHAR(50),
  cover_image VARCHAR(500),
  description TEXT,
  page_count INT,
  language VARCHAR(10),
  categories VARCHAR(255),
  preview_link VARCHAR(500),
  found BOOLEAN,
  error BOOLEAN,
  search_date TIMESTAMP,
  mylocation_id BIGINT
);

-- Creazione tabella mylocation
CREATE TABLE mylocation (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  code VARCHAR(10) NOT NULL UNIQUE
);

-- Vincolo esterno tra books e mylocation
ALTER TABLE books
  ADD CONSTRAINT fk_books_mylocation
  FOREIGN KEY (mylocation_id) REFERENCES mylocation(id);

-- Inserimento posizioni A1 - A7
INSERT INTO mylocation (code) VALUES 
  ('A1'), ('A2'), ('A3'), ('A4'), ('A5'), ('A6'), ('A7');

-- Inserimento posizioni A01 - K07
INSERT INTO mylocation (code) VALUES
  ('A01'), ('A02'), ('A03'), ('A04'), ('A05'), ('A06'), ('A07'),
  ('B01'), ('B02'), ('B03'), ('B04'), ('B05'), ('B06'), ('B07'),
  ('C01'), ('C02'), ('C03'), ('C04'), ('C05'), ('C06'), ('C07'),
  ('D01'), ('D02'), ('D03'), ('D04'), ('D05'), ('D06'), ('D07'),
  ('E01'), ('E02'), ('E03'), ('E04'), ('E05'), ('E06'), ('E07'),
  ('F01'), ('F02'), ('F03'), ('F04'), ('F05'), ('F06'), ('F07'),
  ('G01'), ('G02'), ('G03'), ('G04'), ('G05'), ('G06'), ('G07'),
  ('H01'), ('H02'), ('H03'), ('H04'), ('H05'), ('H06'), ('H07'),
  ('I01'), ('I02'), ('I03'), ('I04'), ('I05'), ('I06'), ('I07'),
  ('J01'), ('J02'), ('J03'), ('J04'), ('J05'), ('J06'), ('J07'),
  ('K01'), ('K02'), ('K03'), ('K04'), ('K05'), ('K06'), ('K07');

-- Inserimento posizioni X01 - X07
INSERT INTO mylocation (code) VALUES
  ('X01'), ('X02'), ('X03'), ('X04'), ('X05'), ('X06'), ('X07');
