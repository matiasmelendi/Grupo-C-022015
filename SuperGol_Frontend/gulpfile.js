var gulp = require('gulp');
var connect = require('gulp-connect');
var jasmineBrowser = require('gulp-jasmine-browser');
var watch = require('gulp-watch');

gulp.task('default', function () {
    console.log('Nothing set as default.');
});

gulp.task('run', function () {
    connect.server({
        root: '.',
        port: 8080
    });
});

gulp.task('tests-js-models', function () {
    var filesForTest = ['resources/js/models/*.js', 'specs/models/*_spec.js']
    return gulp.src(filesForTest)
        .pipe(watch(filesForTest))
        .pipe(jasmineBrowser.specRunner())
        .pipe(jasmineBrowser.server({port: 8081}));
});

gulp.task('tests-angular', function () {
    var filesForTest = ['resources/js/angular.js',
                        'resources/js/angular-mocks.js',
                        'resources/js/angular-route.js',
                        'resources/js/angular-translate.min.js',
                        'app.js',
                        'resources/js/models/*.js' ,
                        'resources/js/controllers/*.js',
                        'specs/angular/**/*_spec.js'];
    return gulp.src(filesForTest)
        .pipe(watch(filesForTest))
        .pipe(jasmineBrowser.specRunner())
        .pipe(jasmineBrowser.server({port: 8081}));
});