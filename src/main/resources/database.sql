INSERT INTO access_levels(access_level_id, description, name, priority) VALUES
(1, 'Web site management access', 'ADMIN', 1),
(2, 'Workflow management access', 'MANAGER', 2),
(3, 'Partial access', 'EMPLOYEE', 3);

INSERT INTO users (user_id, fired, first_name, last_name, password, username, access_level) VALUES
(1, FALSE, 'Edward', 'George', 'admin', 'admin', 1),
(2, FALSE, 'Yarko', 'Remzik', 'manager', 'manager', 2),
(3, FALSE, 'Dimon', 'Rusich', 'employee', 'employee', 3);


INSERT INTO directories (directory_id, date_created, name, parent_directory_id, access_level) VALUES
  (1, NOW(), 'root', NULL, 3),
  (2, NOW(), 'Admin stuff', 1, 1),
  (3, NOW(), 'Manager stuff', 1, 2),
  (4, NOW(), 'Employees stuff', 1, 3);

INSERT INTO sheets (sheet_id, content, title) VALUES
  (1, '[ [1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]', 'sheet number 1'),
  (2, '[ [2, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]', 'sheet number 2'),
  (3, '[ [3, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]', 'sheet number 3'),
  (4, '[ [4, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]', 'sheet number 4');

INSERT INTO documents (document_id, archived, date_created, date_modified, author_id, title, access_level) VALUES
  (1, FALSE, NOW(), NOW(), 1, 'Document 1', 1),
  (2, FALSE, NOW(), NOW(), 2, 'Document 2', 2),
  (3, FALSE, NOW(), NOW(), 3, 'Document 3', 3);

INSERT INTO documents_sheets (document_id, sheet_id, sheets_KEY) VALUES
  (1, 1, 1),
  (2, 2, 1),
  (3, 3, 1),
  (3, 4, 2);

INSERT INTO directory_files (directory_id, document_id) VALUES
  (2, 1),
  (3, 2),
  (4, 3);
