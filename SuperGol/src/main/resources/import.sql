INSERT INTO teams(ID, name) VALUES (1, 'Pepes Team 1')
INSERT INTO teams(ID, name) VALUES (2, 'Pepes Team 2')


INSERT INTO players(ID, name, is_captain, position, team) VALUES (1, 'Pepe 1', true, 1, 1)
INSERT INTO players(ID, name, is_captain, position, team) VALUES (2, 'Pepe 2', true, 2, 1)
INSERT INTO players(ID, name, is_captain, position, team) VALUES (3, 'Pepe 3', true, 2, 1)
INSERT INTO players(ID, name, is_captain, position, team) VALUES (4, 'Pepe 4', true, 2, 1)
INSERT INTO players(ID, name, is_captain, position, team) VALUES (5, 'Pepe 5', true, 3, 1)
INSERT INTO players(ID, name, is_captain, position, team) VALUES (6, 'Pepe 6', true, 3, 1)
INSERT INTO players(ID, name, is_captain, position, team) VALUES (7, 'Pepe 7', true, 3, 1)

INSERT INTO players(ID, name, is_captain, position, team) VALUES (8, 'Pepe 8', true, 1, 2)
INSERT INTO players(ID, name, is_captain, position, team) VALUES (9, 'Pepe 9', true, 2, 2)
INSERT INTO players(ID, name, is_captain, position, team) VALUES (10, 'Pepe 10', true, 2, 2)
INSERT INTO players(ID, name, is_captain, position, team) VALUES (11, 'Pepe 11', true, 2, 2)
INSERT INTO players(ID, name, is_captain, position, team) VALUES (12, 'Pepe 12', true, 3, 2)
INSERT INTO players(ID, name, is_captain, position, team) VALUES (13, 'Pepe 13', true, 3, 2)
INSERT INTO players(ID, name, is_captain, position, team) VALUES (14, 'Pepe 14', true, 3, 2)


INSERT INTO matches(ID, match_result_set) VALUES (1, true)


INSERT INTO match_results(ID, local_points, away_points, match_id, local_scorers, away_scorers) VALUES (1, 0, 0, 1, 1, 2)


INSERT INTO scorers(ID, index, player_id) VALUES (1, 0, 1)
INSERT INTO scorers(ID, index, player_id) VALUES (2, 0, 2)