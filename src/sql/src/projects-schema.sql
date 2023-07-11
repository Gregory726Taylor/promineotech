-- Drop tables
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS materials;
DROP TABLE IF EXISTS steps;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS project_categories;

-- Create tables
CREATE TABLE projects (
  id INT AUTO_INCREMENT PRIMARY KEY,
  project_name VARCHAR(128) NOT NULL,
  estimated_hours DECIMAL(7,2) NOT NULL,
  actual_hours DECIMAL(7,2) NOT NULL,
  difficulty INT NOT NULL,
  notes TEXT NOT NULL
);

CREATE TABLE materials (
  id INT AUTO_INCREMENT PRIMARY KEY,
  project_id INT NOT NULL,
  material_name VARCHAR(128) NOT NULL,
  num_required INT NOT NULL,
  cost DECIMAL(7,2) NOT NULL,
  FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE CASCADE
);

CREATE TABLE steps (
  id INT AUTO_INCREMENT PRIMARY KEY,
  project_id INT NOT NULL,
  step_text TEXT NOT NULL,
  step_order INT NOT NULL,
  FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE CASCADE
);

CREATE TABLE categories (
  id INT AUTO_INCREMENT PRIMARY KEY,
  category_name VARCHAR(128) NOT NULL
);

CREATE TABLE project_categories (
  project_id INT NOT NULL,
  category_id INT NOT NULL,
  UNIQUE (project_id, category_id),
  FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE CASCADE,
  FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE CASCADE
);
