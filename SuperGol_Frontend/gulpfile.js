var gulp = require('gulp');
var connect = require('gulp-connect');
var jasmine = require('gulp-jasmine');

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
    return gulp.src('specs/test.js')
        .pipe(jasmine());
});