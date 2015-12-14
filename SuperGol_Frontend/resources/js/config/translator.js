app.config(function($translateProvider) {
    $translateProvider
        .translations('en', {

            /* Home */
            HOME_MESSAGE: 'Join, choose, play and win!',
            LOG_IN: 'Log in with Google+',

            /* Options */
            TOURNEY: 'Tourney',
            TEAM: 'Team',
            CREATE: 'Create',
            SAVE: 'Save',
            MODIFY: 'Modify',
            UPDATE_ROUND: 'Update round',
            LANGUAGE: 'Language',
            ENGLISH: 'English',
            SPANISH: 'Spanish',
            LOGOUT: 'Logout',

            /* Tourney */
            TOURNEY_CREATION: 'Tourney Creation',
            TOURNEY_NAME: 'Tourney Name (Min. 4)',
            TOURNEY_MIN_AMOUNT: 'Minimum amount of teams',
            TOURNEY_MAX_AMOUNT: 'Maximum amount of teams',
            AVAILABLE_TEAMS: 'Available Teams',
            SELECTED_TEAMS: 'Selected Teams',
            TOURNEY_EDITION: 'Tourney Edition',
            TOURNEY_EMPTY_FIELD: 'The tourney must have a name',
            TOURNEY_EMPTY_MIN_FIELD: 'The tourney must have a minimum amount of teams',
            TOURNEY_EMPTY_MAX_FIELD: 'The tourney must have a maximum amount of teams',
            TOURNEY_WRONG_INPUT_TYPE: 'Value must be a number',
            TOURNEY_MIN_MIN_VALUE: 'The minimum value allowed is 2',
            TOURNEY_MIN_MAX_VALUE: 'The maximum value allowed is the same as maximum amount of teams',
            TOURNEY_MAX_MIN_VALUE: 'The minimum value allowed is the same as minimum amount of teams',
            TOURNEY_MAX_MAX_VALUE: 'The maximum value allowed is amount of possible teams to choose',

            /* Team */
            TEAM_CREATION: 'Team Creation',
            TEAM_EDITION: 'Team Edition',
            TEAM_NAME: 'Team name',
            SELECT_LOGO: 'Select a Logo',
            AVAILABLE_PLAYERS: 'Available Players',
            SELECTED_PLAYERS: 'Selected Players',
            FORMATION: 'Current Formation',
            GOALKEEPERS: 'Goalkeepers',
            DEFENDERS: 'Defenders',
            MIDFIELDERS: 'Midfielders',
            FORWARDS: 'Forwards',
            TEAM_EMPTY_FIELD: 'The team must have a name',
            SHORT_FIELD: 'The name is too short (4. min)',

            /* Round update */
            ROUND_UPDATE: 'Round update',
            SCORES_TITLE: 'Set the scores of the Round Number ',
            PLAYERS: 'Players',
            GOALS: 'Goals',

            /* Ranking */
            TOURNEY_SELECT: 'Select a Tourney'

        })
        .translations('sp', {

            /* Home */
            HOME_MESSAGE: 'Unite, elegi y gana!',
            LOG_IN: 'Ingresa con Google+',

            /* Options */
            TOURNEY: 'Torneo',
            TEAM: 'Equipo',
            CREATE: 'Crear',
            SAVE: 'Guardar',
            MODIFY: 'Modificar',
            UPDATE_ROUND: 'Actualizar Fecha',
            LANGUAGE: 'Idioma',
            ENGLISH: 'Ingles',
            SPANISH: 'Espanol',
            LOGOUT: 'Cerrar Sesion',

            /* Tourney */
            TOURNEY_CREATION: 'Creacion de Torneo',
            TOURNEY_NAME: 'Nombre del Torneo (Min. 4)',
            TOURNEY_MIN_AMOUNT: 'Min. cantidad de equipos',
            TOURNEY_MAX_AMOUNT: 'Max. cantidad de equipos',
            AVAILABLE_TEAMS: 'Equipos disponibles',
            SELECTED_TEAMS: 'Equipos seleccionados',
            TOURNEY_EDITION: 'Edicion de Torneo',
            TOURNEY_EMPTY_FIELD: 'El torneo debe tener un nombre',
            TOURNEY_EMPTY_MIN_FIELD: 'El torneo debe tener una cantidad minima de equipos',
            TOURNEY_EMPTY_MAX_FIELD: 'El torneo debe tener una cantidad maxima de equipos',
            TOURNEY_WRONG_INPUT_TYPE: 'El valor debe ser un numero',
            TOURNEY_MIN_MIN_VALUE: 'El valor minimo permitido es 2',
            TOURNEY_MIN_MAX_VALUE: 'El valor maximo permitido es igual a la cantidad maxima de equipos',
            TOURNEY_MAX_MIN_VALUE: 'El valor minimo permitido es igual a la cantidad minima de equipos',
            TOURNEY_MAX_MAX_VALUE: 'El valor maximo permitido es la cantidad de equipos disponibles',

            /* Team */
            TEAM_CREATION: 'Creacion de Equipo',
            TEAM_EDITION: 'Edicion de Equipo',
            TEAM_NAME: 'Nombre del equipo',
            SELECT_LOGO: 'Seleccione un Logo',
            AVAILABLE_PLAYERS: 'Jugadores disponibles',
            SELECTED_PLAYERS: 'Jugadores seleccionados',
            FORMATION: 'Formacion Actual',
            GOALKEEPERS: 'Arqueros',
            DEFENDERS: 'Defensores',
            MIDFIELDERS: 'Mediocampistas',
            FORWARDS: 'Delanteros',
            TEAM_EMPTY_FIELD: 'El equipo debe tener un nombre',
            SHORT_FIELD: 'El nombre es muy corto (4. min)',

            /* Round update */
            ROUND_UPDATE: 'Actualizacion de Fecha',
            SCORES_TITLE: 'Ingrese el puntaje para la Fecha Numero ',
            PLAYERS: 'Jugadores',
            GOALS: 'Goles',

            /* Ranking */
            TOURNEY_SELECT: 'Seleccione un Torneo'

        });
        $translateProvider.preferredLanguage('en');
});