var gulp = require('gulp'),
    watch = require('gulp-watch');

gulp.task('watch', function () {
    return watch('src/main/resources/**/*.*', () => {
        gulp.src('src/main/resources/**')
            //replace with build/resources/main/ for netBeans
            .pipe(gulp.dest('build/resources/main/'));
    });
});

gulp.task('default', ['watch']);