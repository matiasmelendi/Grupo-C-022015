INSERT INTO formations(ID) VALUES (1)


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


INSERT INTO formation_players(formation_id, index, player_id) VALUES (1, 0, 1)
INSERT INTO formation_players(formation_id, index, player_id) VALUES (1, 1, 2)
INSERT INTO formation_players(formation_id, index, player_id) VALUES (1, 2, 3)
INSERT INTO formation_players(formation_id, index, player_id) VALUES (1, 3, 4)
INSERT INTO formation_players(formation_id, index, player_id) VALUES (1, 4, 5)
INSERT INTO formation_players(formation_id, index, player_id) VALUES (1, 5, 6)
INSERT INTO formation_players(formation_id, index, player_id) VALUES (1, 6, 7)


INSERT INTO allowed_players(formation_id, position, number_of_allowed_players_by_position) VALUES (1, 0, 1)
INSERT INTO allowed_players(formation_id, position, number_of_allowed_players_by_position) VALUES (1, 1, 4)
INSERT INTO allowed_players(formation_id, position, number_of_allowed_players_by_position) VALUES (1, 2, 3)
INSERT INTO allowed_players(formation_id, position, number_of_allowed_players_by_position) VALUES (1, 3, 3)


INSERT INTO matches(ID, match_result_set) VALUES (1, true)


INSERT INTO match_results(ID, local_points, away_points, match_id) VALUES (1, 0, 0, 1)


INSERT INTO scorers(match_result_id, index, player_id) VALUES (1, 0, 1)
INSERT INTO scorers(match_result_id, index, player_id) VALUES (1, 1, 2)