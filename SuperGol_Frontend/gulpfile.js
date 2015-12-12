var gulp = require('gulp');
var connect = require('gulp-connect');
var jasmine = require('gulp-jasmine-phantom');
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
        .pipe(jasmineBrowser.server({port: 8080}));
});

gulp.task('tests-angular', function () {
    var filesForTest = ['node_modules/angular/angular.min.js',
                        'node_modules/angular-mocks/angular-mocks.js',
                        'node_modules/angular-route/angular-route.min.js',
                        'node_modules/angular-translate/dist/angular-translate.min.js',
                        'node_modules/angular-utils-pagination/dirPagination.js',
                        'app.js',
                        'resources/js/models/*.js' ,
                        'resources/js/controllers/*.js',
                        'specs/angular/**/*_spec.js'];
    return gulp.src(filesForTest)
        .pipe(watch(filesForTest))
        .pipe(jasmineBrowser.specRunner())
        .pipe(jasmineBrowser.server({port: 8080}));
});

gulp.task('travis', function () {
    /*
        'node_modules/angular/angular.min.js',
        'node_modules/angular-mocks/angular-mocks.js',
        'node_modules/angular-route/angular-route.min.js',
        'node_modules/angular-translate/dist/angular-translate.min.js',
        'node_modules/angular-utils-pagination/dirPagination.js',
        'app.js',
        'resources/js/models/-.js' ,
        'resources/js/controllers/-.js',
        'specs/angular/--/-_spec.js
    */
    var filesForTest = ['resources/js/models/*.js',
                        'specs/models/*_spec.js'];
    return gulp.src(filesForTest)
        .pipe(jasmine({
            integration: true
        }));
});