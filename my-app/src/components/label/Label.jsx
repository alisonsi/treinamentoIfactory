import React from 'react';
import PropTypes from 'prop-types';
import './Label.css'


const propTypes = {
    types : PropTypes.oneOf(['regular','title']),
    color: PropTypes.string

};
   
function Label(props){
        
    const className = `label-${props.types}`;
    const style = props.color

        return (
            <div className={className} style={style}>
                {props.children}
            </div>
        )
}


Label.propTypes = propTypes;
//Label.defaultProps = defaultProps;

export default Label;