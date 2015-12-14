INSERT INTO formations(ID) VALUES (1)


INSERT INTO tournies(ID, name, minNumberOfTeams, maxNumberOfTeams) VALUES (1, 'Champions League', 2, 16)


INSERT INTO teams(ID, name, formation) VALUES (1, 'Pepes Team 1', 1)
INSERT INTO teams(ID, name, formation) VALUES (2, 'Pepes Team 2', 1)


INSERT INTO tourney_teams(tourney_id, index, team_id) VALUES (1, 0, 1)
INSERT INTO tourney_teams(tourney_id, index, team_id) VALUES (1, 1, 2)


INSERT INTO players(ID, name, captain, position) VALUES (1, 'Pepe 1', false, 1)
INSERT INTO players(ID, name, captain, position) VALUES (2, 'Pepe 2', false, 2)
INSERT INTO players(ID, name, captain, position) VALUES (3, 'Pepe 3', false, 2)
INSERT INTO players(ID, name, captain, position) VALUES (4, 'Pepe 4', false, 2)
INSERT INTO players(ID, name, captain, position) VALUES (5, 'Pepe 5', false, 3)
INSERT INTO players(ID, name, captain, position) VALUES (6, 'Pepe 6', false, 3)
INSERT INTO players(ID, name, captain, position) VALUES (7, 'Pepe 7', true, 3)


INSERT INTO team_players(player_id, index, team_id) VALUES (1, 0, 1)
INSERT INTO team_players(player_id, index, team_id) VALUES (1, 1, 2)
INSERT INTO team_players(player_id, index, team_id) VALUES (2, 0, 1)
INSERT INTO team_players(player_id, index, team_id) VALUES (2, 1, 2)
INSERT INTO team_players(player_id, index, team_id) VALUES (3, 0, 1)
INSERT INTO team_players(player_id, index, team_id) VALUES (3, 1, 2)
INSERT INTO team_players(player_id, index, team_id) VALUES (4, 0, 1)
INSERT INTO team_players(player_id, index, team_id) VALUES (4, 1, 2)

INSERT INTO team_players(player_id, index, team_id) VALUES (5, 0, 1)
INSERT INTO team_players(player_id, index, team_id) VALUES (5, 1, 2)
INSERT INTO team_players(player_id, index, team_id) VALUES (6, 0, 1)
INSERT INTO team_players(player_id, index, team_id) VALUES (6, 1, 2)
INSERT INTO team_players(player_id, index, team_id) VALUES (7, 0, 1)
INSERT INTO team_players(player_id, index, team_id) VALUES (7, 1, 2)


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


INSERT INTO matches(ID, matchResultSet) VALUES (1, true)


INSERT INTO match_results(ID, localPoints, awayPoints, match_id, team_id) VALUES (1, 0, 0, 1, 1)
INSERT INTO match_results(ID, localPoints, awayPoints, match_id, team_id) VALUES (2, 0, 0, 1, 2)


INSERT INTO local_scorers(match_result_id, index, player_id) VALUES (1, 0, 1)
INSERT INTO away_scorers(match_result_id, index, player_id) VALUES (1, 0, 2)


INSERT INTO rounds(ID, number, halfTourney) VALUES (1, 0, 0)


INSERT INTO round_matches(round_id, index, match_id) VALUES (1, 0, 1)


INSERT INTO round_teams(round_id, index, team_id) VALUES (1, 0, 1)
INSERT INTO round_teams(round_id, index, team_id) VALUES (1, 1, 2)


INSERT INTO users(ID, username, password, team) VALUES (1, 'Pepito 1', '1234', 1)
INSERT INTO users(ID, username, password, team) VALUES (2, 'Pepito 2', '1234', 2)
