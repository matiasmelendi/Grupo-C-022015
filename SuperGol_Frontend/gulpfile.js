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

gulp.task('tests', function () {
    var filesForTest = ['resources/js/models/*.js', 'specs/**/*_spec.js']
    return gulp.src(filesForTest)
        .pipe(watch(filesForTest))
        .pipe(jasmineBrowser.specRunner())
        .pipe(jasmineBrowser.server({port: 8081}));
});