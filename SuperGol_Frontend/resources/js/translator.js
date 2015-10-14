app.config(function($translateProvider) {
    $translateProvider
        .translations('en', {
            HOME_MESSAGE: 'Join, choose, play and win!',
            /* Options */
            LEAGUE: 'League',
            TEAM: 'Team',
            CREATE: 'Create',
            MODIFY: 'Modify',
            UPDATE_ROUND: 'Update round',
            LANGUAGE: 'Language',
            ENGLISH: 'English',
            SPANISH: 'Spanish',
            LOGOUT: 'Logout',
        })
        .translations('sp', {
            HOME_MESSAGE: 'Unite, elegi y gana!',
            /* Options */
            LEAGUE: 'Liga',
            TEAM: 'Equipo',
            CREATE: 'Crear',
            MODIFY: 'Modificar',
            UPDATE_ROUND: 'Actualizar Fecha',
            LANGUAGE: 'Idioma',
            ENGLISH: 'Ingles',
            SPANISH: 'Espanol',
            LOGOUT: 'Cerrar Sesion',
        });
        $translateProvider.preferredLanguage('en');
});