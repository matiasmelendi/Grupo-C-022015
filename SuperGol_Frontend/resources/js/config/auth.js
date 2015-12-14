app.config(function (authProvider) {
       authProvider.init({
           domain: 'dajoco.auth0.com',
           clientID: 'Z9mOtHjDMW3V2VN7KqN9hvs9p4Arwqg5'
       });
   })
   .config(function (authProvider, $routeProvider, $httpProvider, jwtInterceptorProvider) {
       jwtInterceptorProvider.tokenGetter = ['store', function(store) {
           return store.get('token');
       }];
       $httpProvider.interceptors.push('jwtInterceptor');
   })
   .run(function(auth) {
       auth.hookEvents();
   })
   .run(function($rootScope, auth, store, jwtHelper, $location, LogService) {
       $rootScope.$on('$locationChangeStart', function() {
           var token = store.get('token');
           if (token) {
               if (!jwtHelper.isTokenExpired(token)) {
                   if (!auth.isAuthenticated) {
                       auth.authenticate(store.get('profile'), token);
                   }
               } else {
                   $location.path('/');
               }
           }
       });
   });