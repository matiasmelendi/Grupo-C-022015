var gulp = require('gulp');
var connect = require('gulp-connect');
var jasmine = require('gulp-jasmine');

var testPaths = ['specs/models/*.js'];

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
    gulp.src(testPaths)
        .pipe(jasmine());
});