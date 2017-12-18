const webpack = require('webpack');
const path = require('path');
const ExtractTextPlugin = require("extract-text-webpack-plugin");
const NODE_ENV = process.env.NODE_ENV || 'development';

module.exports = {
    context: __dirname,
    entry: {
        index: './view/index'
    },
    output: {
        path: path.resolve(__dirname, 'dist'),
        publicPath: '/',
        filename: '[name].js',
        chunkFilename: '[id].js',
        library: '[name]'
    },
    devtool: "source-map",
    resolve: {
        modules: ['node_modules'],
        extensions: ['.js', '.css']
    },

    resolveLoader: {
        modules: ['node_modules'],
        moduleExtensions: ['-loader'],
        extensions: ['.js']
    },
    module: {
        loaders: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['es2015', 'react']
                    }
                }
            }
        ]
    },
    plugins: [
        new webpack.DefinePlugin({
            NODE_ENV: JSON.stringify(NODE_ENV),
        }),
        new webpack.ProvidePlugin({
            ReactDOM:   'react-dom',
            React:      'react',
        })
    ],

    watch: true,

    watchOptions: {
        aggregateTimeout: 100,
        ignored: /node_modules/
    }
};