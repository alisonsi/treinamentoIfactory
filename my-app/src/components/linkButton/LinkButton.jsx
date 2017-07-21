import React from 'react';
import PropTypes from 'prop-types';
import './LinkButton.css'
const LinkButton = props => {
    
    /** @param e {Event} */
    const handlesClick = e =>{
        e.preventDefault();
        e.stopPropagation();
        props.onClick();
    };

    return (
       
            <a href="" className="button-link" onClick={handlesClick} >
                {props.caption}
            </a>
       
    );
};

LinkButton.propTypes = {
    caption: PropTypes.string
};

export default LinkButton;